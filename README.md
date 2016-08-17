# Town of Salem Simulator
## Background

Based off of the original Mafia style party games, Town of Salem is an online flash game with the same premise. Various factions compete against one another to be the last ones standing, with various means to do so. The game has a Town faction, a Mafia faction, and a wide variety of Neutrals to be pitted alongside one another. All of them have various abilities with which they can influence the game, including attacking others, protecting others, collecting information about others, and even swapping targets. 

## Description

This project aims to make a simulation of the game, specifically night one of the game. At first, the user is able to provide any role list from the game that they desire, which can be anywhere from 6 to 15 players. Upon generating the role list, the players in that list will go out and perform their night actions, gathering data, attacking people, and so on. At the very end the user will be shown the result of all the activity that occured in night one in the form of chat logs that are faithful to the flash game. Specifically, for each player, the user will get to see what the game tells them occured that night, from their chosen action(if any), to the result of it as well as any outside infulences such as being killed by a faction. Some chat messages will stray away from being faithful to the game and will instead be there for clarity. A prime example of this would be if two Witches target the same person, only the first Witch can control him, and as such the second Witch will get a message that another witch had controlled them first(whereas in the game, no such notification would appear).


## Next steps

Refactor the old Role class into the abstract class

Work one by one on the Roles and have them function as intended


