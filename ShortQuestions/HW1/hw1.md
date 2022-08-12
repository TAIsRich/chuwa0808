1. LearnMarkDownandshowallofbasicusageintheShortQuestions/README.md
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
2. practicegitusingtheplatform.listthegitcommandsyoulearned
    1. https://learngitbranching.js.org/
       * git commit
       * git add
       * git pull
       * git clone
       * git checkout
       * git push
       * git branch
       * git fetch
       * git reset
       * git merge
       * git log
       * git show
       * git status
3. What is the basic steps to init a git repo in you local?
   create a folder in local to store the code and resources
   `git init XXX`
4. How to clone a repo from Github?
   `git clone XXX`
5. How to create a new branch and checkout to that branch?
   `git branch XXX`
   `git checkout XXX`
6. How to merge the branch_test to master branch in command?show me the commands
   `git checkout master`
   `git merge branch_test`
7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.
    1. commands way
       ```
       git checkout branch_learn_stash
       git stash
       git checkout branch_learn_stash
       git stash pop
       ```
       
8. How do you understand PR is based on Branch?
   1. Pull requests let you tell others about changes you've pushed to a branch in a repository on GitHub.
9. What is maven role?what it be used to do?
   1. Maven is chiefly used for Java-based projects, helping to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of separate packages.
10. What is the lifecycle of maven? could you tell me the details ?
    1. Maven Lifecycle: Below is a representation of the default Maven lifecycle and its 8 steps: Validate, Compile, Test, Package, Integration test, Verify, Install and Deploy.
11. what is the difference between package and install in maven lifecycle ?
    1. The main difference between the “mvn package” and “mvn install” commands is that mvn package command will compile the source and will package it in its distributable formats, such as a JAR or WAR. The mvn install command, however, additionally to compiling the source code and packaging it into a JAR or a WAR, it will also install the package into the local repository, for use as a dependency in other projects locally.
12. What is plugins in maven, list some plugins.
    1. Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects.
    2. plugins:
       1. install
       2. clean
       3. jar
       4. war
       5. help
13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1.  groupID:com.chuwa.learn
    2.  artifactID:java-core
14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
    students' PR, please don't merge it.
