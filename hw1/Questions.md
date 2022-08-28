#### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

#### 2. practice git using the platform. list the git commands you learned

- git commit -m ""
- git add .
- git push
- git status
- git branch newbranch
- git checkout newbranch
- git checkout -b newbranch
- git merge bugFix
- git rebase (takes a set of commits, "copies" them, and plops them down somewhere else.)

- git checkout c1 (detach HEAD)
- git checkout main^: move HEAD up to its parent
- git checkout HEAD^: move HEAD up to its parent
- git branch -f main HEAD~3: move the main branch to three parents behind HEAD.

#### 3. What is the basic steps to init a git repo in you local ?

- create a directory to contain the project
- go to this dir
- type git init .
- write some code
- git add .
- git commit 

#### 4. How to clone a repo from Github ?

 two ways:

- downloead it by clicking the button on github.com
- git clone URL

#### 5. How to create a new branch and checkout to that branch ?

git checkout -b newbranch

#### 6. How to merge the branch_test to master branch in command ? show me the commands

Two ways:

- git merge branch_test
- git rebase branch_test

#### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way

git stash

git stash pop

#### 8. How do you understand PR is based on Branch?

**A PR refers to a branch you want merged into master (or any other branch it's raised against)**. Pushing additional commits to the branch you opened the PR on will add them to the PR.

#### 9. What is maven role ? what it be used to do ?

Easy to download add and remove the dependencies/libraries.

Roles:

- Manage Dependencies

- Build Project 
- Documentation 
- Reporting Others

#### 10. What is the lifecycle of maven? could you tell me the details ?

- `validate` - validate the project is correct and all necessary information is available
- `compile` - compile the source code of the project
- `test` - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
- `package` - take the compiled code and package it in its distributable format, such as a JAR.
- `verify` - run any checks on results of integration tests to ensure quality criteria are met
- `install` - install the package into the local repository, for use as a dependency in other projects locally
- `deploy` - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

#### 11. what is the difference between package and install in maven lifecycle ?

Package & install are various phases in maven build lifecycle. package phase will execute all phases prior to that & it will stop with packaging the project as a jar. Similarly install phase will execute all prior phases & finally install the project locally for other dependent projects.

#### 12. What is plugins in maven, list some plugins.

Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects. They do this by executing an "action" (i.e. creating a WAR file or compiling unit tests) in the context of a project's description - the Project Object Model (POM).

- clean
- compiler
- deploy
- install

#### 13.  In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows: 1. groupID: com.chuwa.learn 2. artifactID: java-core

Please check the folder "./java-core".

