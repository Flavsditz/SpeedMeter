package fly.speedmeter.grub;

import android.os.AsyncTask;

class Stopped extends AsyncTask<Void, Integer, String> {
    private final Data data;
    private int timer = 0;

    Stopped(Data data) {
        this.data = data;
    }

    @Override
        protected String doInBackground(Void... unused) {
            try {
                while (data.getCurrentSpeed() == 0) {
                    Thread.sleep(1000);
                    timer++;
                }
            } catch (InterruptedException t) {
                return ("The sleep operation failed");
            }
            return ("return object when task is finished");
        }

        @Override
        protected void onPostExecute(String message) {
            data.setTimeStopped(timer);
        }
    }