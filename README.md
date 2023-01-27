# Choose best bike to buy with multiple experts.


- [**DEMO**](https://drive.google.com/file/d/1SX7NtdaUmjysFagwgNRZ0NBGJJ_2yXIL/view)

## Authors

1. Damian Tworek
2. Łukasz Zając

## Description
Implementation of AHP decision making method to compare bikes. Program consists of UI interface to add your bikes and multiple agents, then answer generated questions (valuating alternatives) for each expert. Method compares different bikes on their **weight**, number of **gears** and **price**; and allows to specify how much more we value each of those attributes in comparison between each other. After calculations, ranking with each item is shown.

## Architecture

This is overview of architecture used:
<img width="1309" alt="image" src="https://user-images.githubusercontent.com/64365037/214445863-d100be5f-ef96-4054-a331-d526b02cae31.png">
Idea of architecutre:
- Fragments hold UI stuff, but contain minimum amount of logic required.
- Viewmodel/Presenter are the ones, that controls Fragment and what is presented
- Repository is used by Viewmodels/Presenter to store global information
- Calculator when specified how many experts are taking part in calculation can generate all required questions for each of them and expects to recieve all answeres to all of them to fill each matrix accordingly.
- Experts are handled with aggregation of individual priorities (AIP) method. All of the expert's priority rankings are aggregated with arithmetic mean which meets Pareto's principle.

## Installation

- Clone project, and run in Android studio 
- Download [APK and install on your phone](https://drive.google.com/file/d/15fOa1zNaPnC8Ac-RPuP396TVnq_2_jky/view?usp=share_link)

## Testing 
Manual testing.

## Manual
1. Define your bikes to include in calculation (Add Bike button).
2. Define each participating actor.
3. When clicking on actor's name, questions with value dots is being shown to respond accordingly with expert's preference.
4. After answering to all of the questions graph with ranking should be displayed.

## Possible further development
- Adding more/custom features would generify project to apply it in different fields than only bikes.
- Choosing different decision methods.
- Prioritizing experts importance in calculation.
- Display each expert's influence on ranking decision.
- Option to change aggregation methods.
