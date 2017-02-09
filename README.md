# Town of Salem Simulator

## Background

Based off of the original Mafia style party games, Town of Salem is an online flash game with the same premise. 

Various factions compete against one another to be the last ones standing, with various means to do so. The game has a Town faction, a Mafia faction, and a wide variety of Neutrals to be pitted alongside one another. 

All of them have various abilities with which they can influence the game, including attacking others, protecting others, collecting information about others, and even swapping targets. 

## Description

This project aims to make a simulation of the game, specifically night one of the game. 

At first, the user is able to provide their own role list, which can be anywhere from 6 to 15 players. The program takes the role list provided and generates a complete one that can be used for the game. There are no restrictions on the role list, it can be 15 Any Roles or 6 specified roles, as long as the role list abides by game rules.

Upon generating the role list, the players in that list will go out and perform their night actions, gathering data, attacking people, and so on. 

At the very end the user will be shown the result of all the activity that occured in night one in the form of chat logs that are faithful to the flash game. Specifically, for each player, the user will get to see what the game tells them occured that night, from their chosen action(if any), to the result of it as well as any outside infulences such as being killed by a faction. 

Some chat messages will stray away from being faithful to the game and will instead be there for clarity. A prime example of this is when two Witches target the same person. Only the first Witch to control the target will have an effect on them, and as such the second Witch will get a message that another witch had controlled them first(whereas in the game, no such notification would appear).

## Running

As there's no GUI just quite yet...

Go to main/Controller, and modify the role list inside the main function by modifying the roles.add statements. Although the actual game has a maximum size limit of 15 and a minimum of 6, this program can work with any number of players that's not one(as there is no one to compete against).

All entries within the role list must either be a role from the game, a specific alignment within the game(ex: Town Support), a random role from a specific faction(ex: Random Mafia), or an Any to indicate anything goes. There must also not be any impossible role lists, such as mafia roles being present without a killing mafia role. There must also be at least two competing factions within the role list(the Any and Random Neutral slots both count as another faction). The validation suite will detect all of these errors and report them to you appropriately, and you will know what's going wrong and what to fix.

See the below link for all of the roles, and their alignments.

http://town-of-salem.wikia.com/wiki/Roles

Compile and run main within main/Controller.

## Next steps

Implement the GUI and more user options.
