# Choose the best bike to buy!

## Authors

1. Damian Tworek
2. Łukasz Zając

## Description
Implementation of AHP decision making method to compare bikes. Program consists of interface to add bikes and answer generated questions (valuating alternatives). Method compares different bikes on their **weight**, number of **gears** and **price**. After calculations ranking with each item is shown.

## Architecture
Calculator class generates questions and shuffles them. They're sent to gui and after answering to every one of them, list of Answer instances are returned to Calculator in order to calculate final ranking.

MVVM - Model - View - ViewModel

Models:

-   Bike,
  Question,
  Answer,
  Calculator (AHP method)
  
Views:

  - MainFragment, AddBikeFragment, QuestionFragment, ResultFragment,
  
ViewModels:

   - MainViewModel, AddBikeViewModel, QuestionViewModel, ResultViewModel,

## Installation

- Clone project, and run in Android studio 
- Download [APK and install on your phone](https://drive.google.com/file/d/15fOa1zNaPnC8Ac-RPuP396TVnq_2_jky/view?usp=share_link)

## Testing 
Manual testing.
- [**DEMO**](https://drive.google.com/file/d/1WQ6eCBnWR_yBEBNP_QvQJgtvvaP8QEsO/view?usp=share_link)

## Possible further development
Adding more/custom features would generify project to apply it in different fields than only bikes.
Choosing different decision methods.
