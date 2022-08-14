1. LearnMarkDownandshowallofbasicusageintheShortQuestions/README.md
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formattin g-on-github/basic-writing-and-formatting-syntax
    2. check the answer of this question at [readme.md](./README.md)
1. practice git using the platform.list the git commands you learned
    1. https://learngitbranching.js.org/
    2. git commit
    3. git branch
    4. git checkout
    5. git merge
    6. git rebase
    7. git checkout HEAD^
    8. git branch -f main HEAD~3
    9. git checkout HEAD~4
    10. git revert
    11. git reset
    12. git cherry-pick
    13. git rebase -i HEAD~4
    14. 
2. What is the basic steps to init a git repo in you local?
   1. first create a folder in local to store the code and resources
   2. use command 'git init'
   3. write some code inside this folder
3. How to clone a repo from Github?
   1. use command 'git clone XXX'
4. How to create a new branch and checkout to that branch?
   1. use command 'git branch XXX'
   2. use command 'git checkout XXX'
5. How to merge the branch_test to master branch in command?show me the commands
   1. git checkout master
   2. git merge branch_test 
6. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.
   - commands way 
   1. git checkout branch_learn_stash
   2. git stash
   3. git checkout branch_learn_stash
   4. git stash pop
   - intellij way
   1. click shelve changes option
   2. click Unshelve button
7. How do you understand PR is based on Branch?
   1. PR is pull request, which means the main branch will pull code changes from other branch or commit.
8. What is maven role?what it be used to do?
   1. maven is a software project management and comprehenssion tool based on the concept of project object model
   2. it is used to download dependencies which refers to libraries or JAR files 
9.  What is the lifecycle of maven? could you tell me the details ?
    1.  the default lifecycle of maven are Validate, Compile, Test, Package, Integration test, Verify, Install and Deploy. 
10. what is the difference between package and install in maven lifecycle ?
    1.  package step will package the compiled code in distributed format like JAR or WAR
    2.  install step will install the packaged code to the local maven repo
11. What is plugins in maven, list some plugins.
    1.  A plugin is an extension to Maven, something used to produce your artifact
    2.  maven-jar-plugin for an example, is used to make a jar out of your compiled classes and resources
12. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1.  groupID:com.chuwa.learn
    2.  artifactID:java-core
13. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
students' PR, please don't merge it.
