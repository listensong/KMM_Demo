package com.song.kmm.template.unittests;

import androidx.annotation.NonNull;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class RobolectricDemo {
    @SuppressWarnings("FieldCanBeLocal")
    private static final int CURSOR_SIZE = 1;

    private RobolectricDemo() {
        // nothing to do
    }

    @SuppressWarnings("unused")
    public static Answer<Object> cursorAnswer() {
        return new Answer<Object>() {
            private int mPos = -1;

            private final Map<String, Integer> mFakeIndices = cursorFakeColumnIndices();
            private final Map<Integer, Integer> mFakeIntValues = cursorFakeIntValues();

            @Override
            public Object answer(InvocationOnMock invocation) {
                String method = invocation.getMethod().getName();
                switch (method) {
                    case "moveToNext":
                        return ++mPos < CURSOR_SIZE;
                    case "moveToFirst":
                        mPos = 0;
                        return true;
                    case "getCount":
                        return CURSOR_SIZE;
                    case "getColumnIndex":
                        String idx = invocation.getArgument(0);
                        return mFakeIndices.get(idx);
                    case "getInt":
                        int index = invocation.getArgument(0);
                        return mFakeIntValues.get(index);
                    default:
                        return null;
                }
            }
        };
    }

    @NonNull
    private static Map<String, Integer> cursorFakeColumnIndices() {
        Map<String, Integer> content = new HashMap<>(4);
        content.put("one", 0);
        return content;
    }

    @NonNull
    private static Map<Integer, Integer> cursorFakeIntValues() {
        Map<Integer, Integer> content = new HashMap<>(4);
        content.put(1, 120);
        return content;
    }
}
