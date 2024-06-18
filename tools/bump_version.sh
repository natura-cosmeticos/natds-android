#!/bin/bash
git fetch

# Pega a última tag
LAST_TAG=$(git describe --tags --abbrev=0)

# Verifica se existe algum commit com 'major:' no início desde a última tag
if git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^major:'; then
    # Se "major:" for encontrado no início, aumenta a versão major
    npx standard-version --release-as major

# Verifica se existe algum commit com 'breaking:' no início desde a última tag
elif git log "${LAST_TAG}..HEAD" --format='%s' | grep -q -E '^breaking:'; then
    # Se "breaking:" for encontrado no início, aumenta a versão minor
    npx standard-version --release-as minor

else
    # Para todos os outros casos, segue o procedimento padrão que normalmente aumenta o patch
    npx standard-version --release-as patch
fi

# Pega a versão atual do arquivo version.txt
NATDS_VERSION=$(cat ./version.txt)

# Adiciona a versão como variável de ambiente para usos posteriores
envman add --key NATDS_VERSION --value "$NATDS_VERSION"

# Limpa arquivos não rastreados e diretórios
git clean -f -d

# faz o commit
git commit -m "chore: Updates version"
git push --follow-tags origin HEAD
