package com.example.decisionmaking.di

import com.example.decisionmaking.data.RepositoryImpl
import com.example.decisionmaking.domain.interactor.Repository

class DataDI {
    fun provideRepository(): Repository = RepositoryImpl()
}