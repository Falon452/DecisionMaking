# Choose best bike to buy with multiple experts.

## Authors

1. Damian Tworek
2. Łukasz Zając

## Description
Implementation of AHP decision making method to compare bikes. Program consists of UI interface to add your bikes and multiple agents, then answer generated questions (valuating alternatives). Method compares different bikes on their **weight**, number of **gears** and **price**. After calculations ranking with each item is shown.

## Architecture

This is overview of architecture used:
<img width="1309" alt="image" src="https://user-images.githubusercontent.com/64365037/214445863-d100be5f-ef96-4054-a331-d526b02cae31.png">
Idea of architecutre:
- Fragments hold UI stuff, but contain minimum amount of logic required.
- Viewmodel/Presenter are the ones, that controls Fragment and what is presented
- Repository is used by Viewmodels/Presenter to store global information
- Calculator can generate questions required for him to work and expects answers to calculate the final result.


## Installation

- Clone project, and run in Android studio 
- Download [APK and install on your phone](https://drive.google.com/file/d/15fOa1zNaPnC8Ac-RPuP396TVnq_2_jky/view?usp=share_link)

## Testing 
Manual testing.
- [**DEMO**](https://drive.google.com/file/d/1WQ6eCBnWR_yBEBNP_QvQJgtvvaP8QEsO/view?usp=share_link)

## Possible further development
- Adding more/custom features would generify project to apply it in different fields than only bikes.
- Choosing different decision methods.
