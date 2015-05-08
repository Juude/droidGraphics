LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE := app
LOCAL_SRC_FILES := \
	/home/juude/git/DroidGraphics/app/src/main/jni/Android.mk \
	/home/juude/git/DroidGraphics/app/src/main/jni/.cpp \

LOCAL_C_INCLUDES += /home/juude/git/DroidGraphics/app/src/main/jni
LOCAL_C_INCLUDES += /home/juude/git/DroidGraphics/app/src/debug/jni

include $(BUILD_SHARED_LIBRARY)
