# HW # Template
1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
    1. https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formattin g-on-github/basic-writing-and-formatting-syntax

2. practice git using the platform. list the git commands you learned
    1. https://learngitbranching.js.org/

    git commands:
    1. git commit
    2. git checkout/git switch (in Git version 2.23, still considered experimental)
    3. git branch
    4. git checkout -b [thebranchname] (create a new branch AND check it out at the same time)
    5. git merge
    6. git rebase (if we want to rebase the branch onto main, we should check out the branch and then run the command of git rebase main)
    7. git checkout HEAD^
    8. (TO BE CONTINUED)

3. What is the basic steps to init a git repo in you local?
    1. Create a directory("dir") to contain the project; 2. Go into the new dir; 3. Use the git init command; 4. Use "git add" command to add the files needed; 5. Use "git commit" command.

4. How to clone a repo from Github?
    1. Navigate to main page of the repository on Github; 2. Click on "Code" on the main page and get to the Clone panel; 3. Copy the url (i.e., HTTPS or SSH format); 4. In local terminal, use "cd" command to get into the target work directory, and then use the "git clone" command and paste in the url mentioned in step 3 above.

5. How to create a new branch and checkout to that branch?
    In local terminal, use the following command:
    1. Use "cd" command to get into the target directory for the certain git project;
    2. To create a new branch, use command: git branch <branch_name>/notes
    3. To checkout to that branch, use command: git checkout <branch_name>/notes

6. How to merge the branch_test to master branch in command? show me the commands
    1. git checkout master
    2. git merge branch_test

7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
    Commands way:
        1. git checkout branch_learn_stash
        2. git stash
        (checkout other branches to work on and then commit)
        3. git checkout branch_learn_stash
        4. git stash pop (to get the stashed changes back)

    IntelliJ way: (reference from Yilin's HW)
        1. click shelve changes option
        2. click Unshelve button

8. How do you understand PR is based on Branch?
    A branch is a separate version of the code, and a pull request is when someone takes the repo, makes their own branch, does some changes, then tries to merge that branch in, which is putting their changes in other people's code repository.

9. What is maven role? what it be used to do?
    Maven is a powerful project management tool that is based on POM(project object model), and plays the folowing roles: 1) manage dependencies; 2) build project; 3) documentation (Maven extracts the information from the POM to generate the pages under Project Information. The first step in having a good documentation is to have an accurate and visible basic project information, Maven can provide this for the plugin as long as the information in the POM is complete, descriptive and accurate); 4) reporting (Maven has several reports that you can add to your web site to display the current state of the project. These reports take the form of plugin goals, just like those used to build the project).

10. What is the lifecycle of maven? could you tell me the details ?
    The lifecycle of maven is as follows: clean, prepare resources (resources cioying can be customized in this phase), validate (validate if the project is correct and if all necessary information is available), compile (compilation of source code), test(test if the compiled source code is suitable for testing framework), package(creating the JAR/WAR package as mentioned in the packaging in POM.xml), install(this phase installs the packages in local/remote maven repository), and deploy(copying the final packages to the remote repository). Among all of the above, only the step of test can be skipped. 

11. what is the difference between package and install in maven lifecycle ?
    The package phase is for creating the JAR/WAR package in the packaging in POM.xml, while the install phase is for installing the packages in local/remote maven repository 

12. What is plugins in maven, list some plugins.

13. In chuwa0808, MavenProject directory, create a maven Module using Intellij, named it as belows:
    1. groupID:com.chuwa.learn
    2. artifactID:java-core
    Done separately in MavenProject directory.

14. Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.