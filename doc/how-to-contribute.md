# How to contribute - WIP

Are you feeling that you can help us with anything in the project? Just get closer!!

There are many ways to contribute, check some of them:
## Do you want add something in the project? Just create a PR
We will review your PR, checking some criteria and if everything is fine, a new version of the lib will be publish with your contribution ASAP!

### Commits strcuture
To commit your PR, we indicate the usage of [Conversional Commits] (https://www.conventionalcommits.org/en/v1.0.0/).

The most common types the we use is:
Are you adding a new feature, your commit should look like: feat: [Short Description] [long description if you need]
Are you fixing a bug, your commit should look like: bug: [Short Description] [long description if you need]
Are you adding tests, your commig should look like: test: [Short Description] [long description if you need]

There are many other types that you can use to tag your commits: build:, chore:, ci:, docs:, style:, refactor:, perf:
[here you can find more infos about it](https://www.conventionalcommits.org/en/v1.0.0/).

#### Tool to help:
You can add an CLI to help you writing your commits. [Commitizen](https://github.com/commitizen/cz-cli) is the tool we use :)
##### Install the CLI
```bash
npm install -g commitizen
```
###### Do your work and commit
```bash
git add .
git cz
```

Commitizen will guide you about how to structure you commit

### Review criteria
Fine, now you should be asking your self, which critearia will be checked? Here some of them:
- Your code is covered by tests
- Your code is well strcutured, respecting SOLID principals
- Your code passed our automatic verifications (you can check the pipeline flow link in your PR) - and you can run this flow localy (check here for more info)
- You added a sample of the increment at Sample App (remember to updated the tests related to it)
- Your have made corresponding changes to the documentation
- Your changes generate no new warnings

#### Do you find something that could be diferent in the lib and you want to let us know?
you can open an Issue and explain to us yout point. We're always checking new issues an working to keep your lib updated

#### Do you have any questions about the lib? Please contact us in XXXXXXX
