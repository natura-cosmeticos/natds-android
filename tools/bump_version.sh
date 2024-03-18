#!/bin/bash
git fetch

# Pega a última tag
LAST_TAG=$(git describe --tags --abbrev=0)

# Verifica se existe algum commit com 'major:' desde a última tag
if git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E 'major:'; then
    # Se "major:" for encontrado, aumenta a versão major
    npx standard-version --release-as major
# Verifica se existe algum commit com 'break:' desde a última tag
elif git log "${LAST_TAG}..HEAD" --format='%b' | grep -q -E '^breaking:'; then
    # Se "breaking:" for encontrado, aumenta a versão major
    npx standard-version --release-as major
# Verifica por outros tipos de commits
elif git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -i -E '^feat|fix|perf|refactor|revert$'; then
    # Procede com a versão padrão
    npx standard-version
else
    echo "No applicable changes since the previous tag, skipping..."
fi

# Pega a versão atual do arquivo version.txt
NATDS_VERSION=$(cat ./version.txt)

# Adiciona a versão como variável de ambiente para usos posteriores
envman add --key NATDS_VERSION --value "$NATDS_VERSION"

# Limpa arquivos não rastreados e diretórios
git clean -f -d

# Commit as mudanças caso tenham ocorrido
if [ -n "$(git status --porcelain)" ]; then
  git commit -am "chore: Updates version"
  git push --follow-tags origin HEAD
else
  echo "No files to commit."
fi
