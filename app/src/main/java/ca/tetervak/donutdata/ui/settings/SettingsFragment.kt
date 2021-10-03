package ca.tetervak.donutdata.ui.settings

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import ca.tetervak.donutdata.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}