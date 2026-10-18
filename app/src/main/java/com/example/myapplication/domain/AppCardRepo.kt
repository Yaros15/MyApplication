
package com.example.myapplication.domain

import com.example.myapplication.data.AppCard

interface AppCardRepo {

    fun getAllCardsApp(): List<AppCard>

}