package com.example.practic5;

import android.os.Bundle;
import android.os.Handler;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class SecondFragment extends Fragment {
    private TextView textView;
    private int counter = 0;
    private boolean isRunning = false;
    private Handler handler = new Handler();

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (isRunning) {
                counter++;
                textView.setText(String.valueOf(counter));
                handler.postDelayed(this, 1000); // обновление каждую секунду
            }
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        textView = view.findViewById(R.id.textView);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(getActivity(), v);
            MenuInflater inflaterMenu = getActivity().getMenuInflater();
            inflaterMenu.inflate(R.menu.popup_men, popupMenu.getMenu());

            popupMenu.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.start_sec) {
                    startTimer();
                } else if (item.getItemId() == R.id.stop_sec) {
                    stopTimer();
                }
                return true;
            });
            popupMenu.show();
        });

        return view;
    }

    private void startTimer() {
        if (!isRunning) {
            isRunning = true;
            handler.post(runnable);
        }
    }

    private void stopTimer() {
        isRunning = false;
        handler.removeCallbacks(runnable);
    }
}
