package me.amryousef.robotest

import javax.inject.Inject

class FakeDataProviderImpl @Inject constructor() : FakeDataProivder {
    override fun getFakeData() = "I am a fake message"
}