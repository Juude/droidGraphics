package net.juude.droidgraphics;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by juude on 15-4-2.
 */
public class EditFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        EditText editText = new EditText(getActivity());
        editText.setBackgroundColor(Color.RED);
        return editText;
    }
}
