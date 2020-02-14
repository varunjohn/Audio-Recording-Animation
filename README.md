# Audio-Recording-Animation
WhatsApp like audio recording animations and views sample for Android.  

![varunjohn-audio-record-code-sample](https://user-images.githubusercontent.com/24667361/74533858-8f699880-4f58-11ea-9316-f7528368e201.gif)


Hold the mic and the timer will start (starts voice recording), now you can slide left to cancel or slide up to lock, release the mic to send (stops recording and sends the voice note). Although you have to write the code for recording audio and saving yourself. This sample will only give you the views and animations, perhaps the difficult part. 
GOODLUCK!!!

## What's New ?
1. Attachment option with animation.
2. Image icon for Emoji and Camera.
3. Multiline EditText view.
4. RTL layout support.

## Gradle dependency

Add this dependency in your app level build.gradle file

[ ![Download](https://api.bintray.com/packages/varunjohn1990/Maven/WhatsappMessengerView/images/download.svg) ](https://bintray.com/varunjohn1990/Maven/WhatsappMessengerView/_latestVersion)

```
implementation 'com.varunjohn1990.libraries:WhatsappMessengerView:2.0.0'
```


## How to use

The chatting activity has to be empty and give the id

```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/layoutMain"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FAF6E3"
    tools:context=".ChattingActivity">
    
</FrameLayout>
```
Intitial the AudioRecordView with the root layout. Pass the view to audioRecordView.initView(view) method. 
Also make the seperate container layout for the chatting activity which will contain the recycle view, or design however you like. Then set the layout with audioRecordView.setContainerView(layoutResourceId) method, the method will return the containerView.

```
audioRecordView = new AudioRecordView();

// this is to make your layout the root of audio record view, root layout supposed to be empty..
audioRecordView.initView((FrameLayout) findViewById(R.id.layoutMain));
// this is to provide the container layout to the audio record view..
View containerView = audioRecordView.setContainerView(R.layout.layout_chatting);
recyclerViewMessages = containerView.findViewById(R.id.recyclerViewMessages);
```

Now get set the Recording callback listeners. It provides the callback methods on the basis of user interactions.
So, in onRecordingStarted method you can start recording audio with the help of MediaRecorder class and
in onRecordingCompleted method call you can stop and save the audio file.
in onRecordingCanceled method you can delete the audio file.
Just use whatever suits the requirements.

```
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
### Attachment Options

This gives the whatsapp like reveal animation when you click the attachment icon. 
Pass the List<AttachOption> and AttachmentOptionsListener to udioRecordView.setAttachmentOptions(). You can use the Default attachment options, customize it or send a custom list. 

**NOTE : Use not more then 6 attachment options.**

```
 audioRecordView.setAttachmentOptions(AttachmentOption.getDefaultList(), new AttachmentOptionsListener() {
            @Override
            public void onClick(AttachmentOption attachmentOption) {
                switch (attachmentOption.getId()) {

                    case AttachmentOption.DOCUMENT_ID: //Ids for default Attachment Options
                        showToast("Document Clicked");
                        break;
                    case AttachmentOption.CAMERA_ID:
                        showToast("Camera Clicked");
                        break;
                    case AttachmentOption.GALLERY_ID:
                        showToast("Gallery Clicked");
                        break;
                    case AttachmentOption.AUDIO_ID:
                        showToast("Audio Clicked");
                        break;
                    case AttachmentOption.LOCATION_ID:
                        showToast("Location Clicked");
                        break;
                    case AttachmentOption.CONTACT_ID:
                        showToast("Contact Clicked");
                        break;
                }
            }
        });
```
Make a custom list like this. Use AttachmentOption model class just pass an id, option title and an icon drawable resource id in the constructor.

```
List<AttachmentOption> attachmentOptions = new ArrayList<>();
attachmentOptions.add(new AttachmentOption(ADD_FILE_ID, "Add File", R.drawable.ic_add_file));
```


### All available options

```
//Show AttachmentOptionView with reveal animation..
audioRecordView.showAttachmentOptionView();

//To hide AttachmentOptionView..
audioRecordView.hideAttachmentOptionView();

//To remove the attachment options icons animation..
audioRecordView.removeAttachmentOptionAnimation(false);

//To hide the options you don't want..
audioRecordView.setShowAttachmentIcon(true);
audioRecordView.setShowCameraIcon(false);
audioRecordView.setShowEmojiIcon(true);

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

You can also change the icons for the views like this.

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
