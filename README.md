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

## Next steps

Implement the GUI and publish this onto a website

## 100 Commit Milestone

The journey first began on a flight back home, where the program was born and made into a ranked role list generator. Realizing the potential of the generator, the program then started the slow transformation into being a night one simulator of the generated role list. 

The program eventually met its goal and was able to simulate everything how it was desired. A sense of accomplishment, but also a sense of desire to continue. The output is only terminal based, and it's restricted to a specific role list... what if...

So it was decided. The program would be made to have a UI, and would give the user total freedom of the role list that they would want to put into the simulation. UIs in Java was an unfamiliar concept, but netherless the topic was learned about and the UI was developed to a point of where there was total confidence over its control.

Upon reaching that point, the UI was put on hold and the work switched back onto the simulation. The previous generator was overhauled into something much bigger. Requring an expansive user input validator, and a lot of logic put into it, the generator was eventually live and ready to process anything the user could throw at it.

The simulation had finally been tackled and brought to, and the game could now handle anything the user could throw at it. The last step remains, the interface.


From a project that started as a small tool on an airplane, it had slowly grown into something bigger and bigger. It was quite an experience seeing all the different things that this project had become so far, and all the new things learned during its development. My only hope is that users on release will be able to enjoy this program as much as I enjoyed making it.
