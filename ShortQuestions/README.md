# HW # Template
### 3.  What is the basic steps to init a git repo in you local ?
 1.Create a directory to contain the project.
 2.Go into the new directory.
 3.Type git init .
 4.Write some code.
 5.Type git add to add the files (see the typical use page).
 6.Type git commit .

### 4.  How to clone a repo from Github ?
 1.In the File menu, click Clone Repository.
 2.Click the tab that corresponds to the location of the repository you want to clone. ...
 3.Choose the repository you want to clone from the list.
 4.Click Choose... and navigate to a local path where you want to clone the repository.
 5.Click Clone.

### 5. How to create a new branch and checkout to that branch ?
1.create a new branch off main using git branch new_branch . Once created you can then use git checkout new_branch to switch to that branch.
2.Checkout to the branch where you want to copy the file. git checkout feature/A.
3.Once you are on the correct branch, copy the file. git checkout feature/B -- utils.js.
4.Use the git status command to ensure that the file has been copied.
5.Commit and push to a remote.

### 6.  How to merge the branch_test to master branch in command ? show me the commands
1.First we run git checkout master to change the active branch back to the master branch
2.Then we run the command git merge new-branch to merge the new feature into the master branch
3.git branch development
4.git add *
5.git commit -m "My initial commit message"
6.git push -u origin development

### 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
    checkout back to **branch_learn_stash ? try commands way and intellij way.
1.git stash 
2.git pull 
3.git stash pop
4.$ git stash pop stash@{2}
5.git stash list

### 8.  How do you understand PR is based on Branch?
A PR refers to a branch you want merged into master (or any other branch it's raised against). Pushing additional commits to the branch you opened the PR on will add them to the PR

### 9.  What is maven role ? what it be used to do ?
Maven is chiefly used for Java-based projects, helping to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of separate packages

### 10.  What is the lifecycle of maven? could you tell me the details ?
Maven makes the day-to-day work of Java developers easier and helps with the building and running of any Java-based project. Maven Lifecycle: Below is a representation of the default Maven lifecycle and its 8 steps: Validate, Compile, Test, Package, Integration test, Verify, Install and Deploy

### 11.  what is the difference between package and install in maven lifecycle ?
Package & install are various phases in maven build lifecycle. package phase will execute all phases prior to that & it will stop with packaging the project as a jar. Similarly install phase will execute all prior phases & finally install the project locally for other dependent projects.

### 12.  What is plugins in maven, list some plugins.
Plugins are the central feature of Maven that allow for the reuse of common build logic across multiple projects. They do this by executing an "action" (i.e. creating a WAR file or compiling unit tests) in the context of a project's description - the Project Object Model (POM).
1.clean – Once the build is completed, these plugins cleans it up.
2.compiler – The Java source file is compiled by the compiler plugin.
3.deploy – The built artifact is deployed to a remote repository via the deploy plugin.
4.failsafe – In an isolated classloader, the failsafe plugin is used to run the JUnit integration.
5.install – The built artifact is installed into the local repository with the help of this plugin.
6.resources – The inclusion of the JAR is done by copying the resources to the output directory with this plugin.
7.site – The generation of the site for a project is done with the site plugin.
8.verifier – To verify certain conditions, and to ensure integration tests, the verifier plugin is useful.

### 13.  In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core
already create

### 14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
     students' PR, please don't merge it.
     git pull origin first_name/notes