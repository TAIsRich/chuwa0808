### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
See README.md
### 2. practice git using the platform. list the git commands you learned
```
git commit -m ""
git add
git branch
git checkout 
git status
git pull/fetch
git push origin/
git reset --hard
```
### 3. What is the basic steps to init a git repo in you local ?
```
Create a directory to contain the project
Go into the new directory
Type git init 
Write some code
Type git add to add the files (see the typical use page)
Type git commit 
```
### 4. How to clone a repo from Github ?
```
git clone
```
### 5. How to create a new branch and checkout to that branch ?
```
git checkout -b
```
### 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout master
git merge branch_test
```
### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```
Run git stash
Check out other branch and push
Check out branch_learn_stash
Run git stash pop to get your stashed changes back
```
### 8. How do you understand PR is based on Branch?
A pull request is an event in Git where a contributor asks a maintainer of a Git repository (i.e. main branch) to review code they want to merge into main branch.
### 9. What is maven role ? what it be used to do ?
Maven is loaded with many valuable and useful features, which goes a long way towards explaining its popularity. Here are some of Maven’s more noteworthy features:
- A huge, continuously growing repository of user libraries
- The ability to set up projects easily, using best practices
- Dependency management, featuring automatic updating
- Backwards compatible with previous versions
- Strong error and integrity reporting
- Automatic parent versioning
- Ensures consistent usage across all projects

It’s extensible, and you can easily write plug-ins using scripting languages or Java.

Maven is chiefly used for Java-based projects, helping to download dependencies, which refers to the libraries or JAR files. The tool helps get the right JAR files for each project as there may be different versions of separate packages. 
### 10. What is the lifecycle of maven? could you tell me the details ?
1. Validate: This step validates if the project structure is correct. For example – It checks if all the dependencies have been downloaded and are available in the local repository.
2. Compile: It compiles the source code, converts the .java files to .class and stores the classes in target/classes folder.
3. Test: It runs unit tests for the project.
4. Package: This step packages the compiled code in distributable format like JAR or WAR.
5. Integration test: It runs the integration tests for the project.
6. Verify: This step runs checks to verify that the project is valid and meets the quality standards.
7. Install: This step installs the packaged code to the local Maven repository.
8. Deploy: It copies the packaged code to the remote repository for sharing it with other developers.
### 11. what is the difference between package and install in maven lifecycle ?
mvn package command will compile source code and also package it as a jar or war as per pom file and put it into the target folder(by default). mvn install command will compile and package, but it will also put the package in your local repository.
### 12. What is plugins in maven, list some plugins.
- Build plugins: They execute during the build process and should be configured in the <build/> element of pom.xml.
- Reporting plugins: They execute during the site generation process and they should be configured in the <reporting/> element of the pom.xml.
- Following is the list of few common plugins:
- clean: Cleans up target after the build. Deletes the target directory.
- compiler: Compiles Java source files.
- surefire: Runs the JUnit unit tests. Creates test reports.
- jar: Builds a JAR file from the current project.
- war: Builds a WAR file from the current project.
- javadoc: Generates Javadoc for the project.
- antrun: Runs a set of ant tasks from any phase mentioned of the build.
### 13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1. groupID: com.chuwa.learn
    2. artifactID: java-core
### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it
