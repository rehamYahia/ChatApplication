package com.task.chatapp.data.saveentry

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.task.chatapp.utilis.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class userlocalmanger(
    private val context: Context
):userlocalmangerinter {
    override suspend fun saveuserentry() {
        context.datastore.edit {
                setting->
            setting[prefrenceskeys2.user_key]=true
        }

    }

    override  fun readUserentry(): Flow<Boolean> {
        return context.datastore.data.map {
                pref->
            pref[prefrenceskeys2.user_key]?:false
        }
    }


}

private val Context.datastore : DataStore<Preferences> by preferencesDataStore(name = Constants.pref_name2 )

private object prefrenceskeys2{

    val user_key= booleanPreferencesKey(name = Constants.key2)



}
