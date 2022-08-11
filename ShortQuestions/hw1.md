### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
#### https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax
Markdown is two things:
1. a plain text formatting syntax; and
1. a software tool, written in Perl, that converts the plain text formatting to HTML.
 
### 2. practice git using the platform. list the git commands you learned
#### https://learngitbranching.js.org/
- git commit
- git branch
- git checkout
- git merge
- git rebase

### 3. What is the basic steps to init a git repo in you local ?
```
Create a directory to contain the project.
Go into the new directory.
Type git init .
Write some code.
Type git add to add the files.
Type git commit .
```

### 4. How to clone a repo from Github ?
```
On GitHub.com, navigate to the main page of the repository.
Above the list of files, click Code.
Copy the URL for the repository. To clone the repository using HTTPS, under "HTTPS", click . ...
Open .
Change the current working directory to the location where you want the cloned directory.
```

### 5. How to create a new branch and checkout to that branch ?
```
git checkout -b branchName
or:
git branch branchName
git checkout branchName
```

### 6. How to merge the branch_test to master branch in command ? show me the commands
```
git checkout main
git merge branch_test
```

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
checkout back to **branch_learn_stash ? try commands way and intellij way.
```
git stash
git stash pop
```

### 8. How do you understand PR is based on Branch?
```
A pull request is when someone take the repo, makes their own branch, does some changes, 
then tries to merge that branch in (put their changes in the other person's code repository).
```

### 9. What is maven role ? what it be used to do ?
```
Maven is a powerful project management tool that is based on POM (project object model). 
It is used for projects build, dependency and documentation. It simplifies the build process like ANT. 
But it is too much advanced than ANT.
In short terms we can tell maven is a tool that can be used for building and managing any Java-based project. 
maven make the day-to-day work of Java developers easier and generally help with the comprehension of 
any Java-based project.

Maven does a lot of helpful task like

We can easily build a project using maven.
We can add jars and other dependencies of the project easily using the help of maven.
Maven provides project information (log document, dependency list, unit test reports etc.)
Maven is very helpful for a project while updating central repository of JARs and other dependencies.
With the help of Maven we can build any number of projects into output types like the JAR, WAR etc without doing any scripting.
Using maven we can easily integrate our project with source control system (such as Subversion or Git).
```

### 10. What is the lifecycle of maven? could you tell me the details ?
```
A Build Lifecycle is a well-defined sequence of phases, which define the order in which the goals are to be executed. 
Here phase represents a stage in life cycle. As an example, a typical Maven Build Lifecycle consists of the 
following sequence of phases.

Phase			Handles					Description
prepare-resources	resource copying		Resource copying can be customized in this phase.
validate		Validating the information	Validates if the project is correct and if all necessary information is available.
compile			compilation			Source code compilation is done in this phase.
Test			Testing				Tests the compiled source code suitable for testing framework.
package			packaging			This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.
install			installation			This phase installs the package in local/remote maven repository.
Deploy			Deploying			Copies the final package to the remote repository.
```

### 11. what is the difference between package and install in maven lifecycle ?
```
Well, both will clean. That means they'll remove the target folder. 
package will compile your code and also package it. For example, if your pom says the project is a jar, it will create a jar for you when you package it and put it somewhere in the target directory (by default).

install will compile and package, but it will also put the package in your local repository. 
This will make it so other projects can refer to it and grab it from your local repository.
```

### 12. What is plugins in maven, list some plugins.
```
The maven plugins are central part of maven framework, it is used to perform specific goal.
According to Apache Maven, there are 2 types of maven plugins.
Build Plugins: These plugins are executed at the time of build. These plugins should be declared inside the <build> element.
Reporting Plugins: These plugins are executed at the time of site generation. These plugins should be declared inside the <reporting> element.
Eg: clean
Cleans up target after the build. Deletes the target directory.
```

### 13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core

### 14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other
students' PR, please don't merge it.

