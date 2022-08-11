## hw1

### 1. Learn **MarkDown** and show all of basic usage in the **ShortQuestions/README.md**.
#### https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

[README](https://github.com/TAIsRich/chuwa0808/blob/Flora_Zhong/hw1/ShortQuestions/HW1/README.md)

### 2. Practice git using the platform. List the git commands you learned.
#### https://learngitbranching.js.org/

```
git config --global
git config --list
git clone
git branch 
git branch -d
git checkout
git checkout -b
git push 
git push --all
git add
git commit -a
git commit -m
git commit -a -m
git fetch
git pull
git rebase
git pull --rebase
git merge
git reset
git revert
```

### 3. What is the basic steps to init a git repo in you local?

```
- create and enter a new directory

- git clone a repo URL 
  or 
  git init: create an empty git repository or reinitialize an existing one
```

### 4. How to clone a repo from Github?

```
git clone a repo URL (HTTPS)
```

### 5. How to create a new branch and checkout to that branch?

```
- git checkout -b BRANCH_NAME: create a new branch and check out the new branch 
or 
- git branch BRANCH_NAME: create a new branch
- git switch BRANCH_NAME: switch to the new branch
  or 
  git checkout BRANCH_NAME: switch to the new branch
```

### 6. How to merge the branch_test to master branch in command? Show me the commands.

```
git checkout branch_master
git merge branch_test
```

### 7. How to **stash** your new code before leaving branch **branch_learn_stash** and pop your stash when you check out back to **branch_learn_stash**? Try commands way and intellij way.

```
git commands way:

// check status, stash the current work, check all the stashes, check status, switch another branch, check status
(- git status)
- git stash
- git stash list
(- git status)
- git checkout another_branch_name
(- git status)

//back to branch_learn_stash
- git checkout branch_learn_stash

// recover the most recent stash or recover the specific stash
- git stash pop
or 
- git stach pop stash_name
```

```
Intellij way: visual representation using the picture of xia_zhao
```

[Intellij (un)stash](./intellij_(un)stash.png)

### 8. How do you understand **PR is based on Branch**?

```
PR: pull request
When Person 1 wants to merge his branch to main or some other branch, the main or the target branch may be changed comparing to the original version which you cloned, because Person 2 has checked in his code already. Now you need send a pull request to merge to the possibally changed version. You also need to reslove the conflicts between your code and his before you merge your branch if there is any conflict.   
```

### 9. What is maven's role? What is it used to do?

```
- Maven helps the developer to create a java-based project more easily. It increases the performance of project and building process.

- Maven can download the jars and dependency libraries automatically.

- Using maven we can easily integrate our project with a source control system such as git. Maven is very helpful for a project while updating central repository of JARs and other dependencies.

- Maven provides project information such as log document, dependency list, and unit test reports etc.

- With the help of Maven, we can build any number of projects into output types like the JAR and WAR etc without doing any scripting.
```

### 10. What is the lifecycle of maven? Could you tell me the details?

```
clean -> prepare-resources -> validate -> package -> install
```
[Maven Build Lifecycle](./maven_build_lifecycle.png)

### 11. What is the difference between package and install in maven lifecycle?

```
Package and install are various phases in the maven build lifecycle. Package phase will execute all phases prior to itself, and will compile the source and package the project in its distributable formats such as a JAR or WAR. Install phase will execute all prior phases prior to itself, and install the package into the local repository using for other dependent projects locally, beside compiling the source code and packaging the project into a JAR or WAR. 
```

### 12. What is plugins in maven? List some plugins.

```
Maven is actually a plugin execution framework where every task is actually done by plugins. Maven Plugins are generally used to
- create jar file
- create war file
- compile code files
- unit testing of code
- create project documentation
- create project reports

Build plugins: 
They execute during the build process and should be configured in the <build/> element of pom.xml.
Reporting plugins:
They execute during the site generation process and they should be configured in the <reporting/> element of the pom.xml.

List of a few common plugins: 
- clean: Clean up target after the build. Delete the target directory.
- compiler: Compile Java source files.
- surefire: Run the JUnit unit tests, and create test reports.
- jar: Build a JAR file from the current project.
- war: Build a WAR file from the current project.
- javadoc: Generate a Javadoc for the project.
- antrun: Run a set of ant tasks from any phase mentioned of the build.
```

### 13. In **chuwa0808**, **MavenProject** directory, create a Maven Module using Intellij, and named it belows:
#### 1. groupID: com.chuwa.learn
#### 2. artifactID: java-core

[Maven Module](https://github.com/TAIsRich/chuwa0808/blob/Flora_Zhong/hw1/MavenProject/module/pom.xml)

### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please **do not** merge it.