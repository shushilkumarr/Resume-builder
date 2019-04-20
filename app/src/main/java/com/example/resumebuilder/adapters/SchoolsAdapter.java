package com.example.resumebuilder.adapters;

import android.support.annotation.NonNull;

import com.example.resumebuilder.datamodels.School;

import java.util.List;

public class SchoolsAdapter extends ResumeEventAdapter<School> {

    public SchoolsAdapter(@NonNull List<School> list,
                          ResumeEventOnClickListener resumeEventOnClickListener) {
        super(list, resumeEventOnClickListener);
    }
}