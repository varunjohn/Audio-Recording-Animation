# Audio-Recording-Animation (v2 Coming soon)
WhatsApp like audio recording animations and views sample for Android.  

![varunjohn-audio-record-code-sample](https://user-images.githubusercontent.com/24667361/49446780-f4751a80-f7fa-11e8-87cd-a6e2999fa841.gif)


Hold the mic and the timer will start (starts voice recording), now you can slide left to cancel or slide up to lock, release the mic to send (stops recording and sends the voice note). Although you have to write the code for recording audio and saving yourself. This sample will only give you the views and animations, perhaps the difficult part. 
GOODLUCK!!!

First need to add AudioRecordView in xml resource layout file.

```
<com.varunjohn1990.audiorecordingview.AudioRecordView
        android:id="@+id/recordingView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_gravity="bottom" />
```

Now get the AudioRecordView in Activity and add the callback listeners.

```
audioRecordView = findViewById(R.id.recordingView);
audioRecordView.setRecordingListener(new AudioRecordView.RecordingListener() {
            @Override
            public void onRecordingStarted() {
            }

            @Override
            public void onRecordingLocked() {
            }

            @Override
            public void onRecordingCompleted() {
            }

            @Override
            public void onRecordingCanceled() {
            }
        });

```

You can get the required views from AudioRecordView.

```
audioRecordView.getMessageView();
audioRecordView.getAttachmentView();
audioRecordView.getSendView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = audioRecordView.getMessageView().getText().toString();
                audioRecordView.getMessageView().setText("");
                messageAdapter.add(new Message(msg));
            }
        });
```

You can also change the image for the views.

```
audioRecordView.setAudioRecordButtonImage(R.drawable.record_audio_ic);
audioRecordView.setSendButtonImage(R.drawable.send_msg_ic);

```


## About Me
Varun John<br />
Sr. Android Developer<br />
varunjohn1990@gmail.com<br />
Skype varun.john1990<br />
Follow me https://github.com/varunjohn for other samples and libraries like these

**If you like this sample then please add a star on this project :)**


## License
```
   Copyright 2018 Varun John

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
