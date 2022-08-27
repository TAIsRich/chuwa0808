### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
 https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

### 2. practice git using the platform. list the git commands you learned https://learngitbranching.js.org/
- git commit
- git branch
- git checkout
- git checkout -b
- git merge
- git rebase

### 3. What is the basic steps to init a git repo in you local ?
```
Create a new directory at local
cd to the new directory
git init to initiate the local repository.
```

### 4. How to clone a repo from Github ?
```
git clone https or SSH
```

### 5. How to create a new branch and checkout to that branch ?
```
git branch new_branch
git checkout new_branch
```
or 
```
git checkout -b new_branch
```

### 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
```

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```
git stash - stash current work
git stash list - list all the stashes
git stash pop - recover the most recent stash
git stash pop {stash_name} - recover a specific stash
```

### 8. How do you understand PR is based on Branch?
```
PR is pull request,
When we are done editing a source brance, we make a PR to reuqest to merge this source brance into the target branch
```

### 9. What is maven role ? what it be used to do ?
```
Maven's role:
- Manage dependencies
- Build project
- Documentation
- Reporting
- Others

Maven is used to download add and remove the dependencies/libraries easily
```

### 10. What is the lifecycle of maven? could you tell me the details ?
```
Clean -> prepare-resources -> validate -> package -> install
```

### 11. what is the difference between package and install in maven lifecycle ?
```
They are different phases of Maven lifecycle:
package: This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml
install: This phase installs the package in local/remote maven repository
```

### 12. What is plugins in maven, list some plugins.
```
Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects.
E.g. clean, deploy, compile, and etc. 
```
