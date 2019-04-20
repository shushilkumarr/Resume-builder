package com.example.resumebuilder.fragments;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.resumebuilder.EditActivity;
import com.example.resumebuilder.adapters.ProjectsAdapter;
import com.example.resumebuilder.adapters.ResumeEventAdapter;
import com.example.resumebuilder.datamodels.Project;
import com.example.resumebuilder.datamodels.Resume;
import com.example.resumebuilder.helper.ResumeEventFragment;
import com.example.resumebuilder.helper.ResumeFragment;

public class ProjectsFragment extends ResumeEventFragment<Project> {
    public static ResumeFragment newInstance(Resume resume) {
        ResumeFragment fragment = new ProjectsFragment();
        fragment.setResume(resume);
        return fragment;
    }

    @Override
    protected void delete(int pos) {
        getResume().projects.remove(pos);
    }

    @Override
    public void onClick(int position) {
        Intent intent = EditActivity.getProjectIntent(getContext());
        EditActivity.setData(intent, position, getResume().projects.get(position));
        startActivityForResult(intent, REQUEST_EDIT);
    }

    @Override
    protected void addClicked() {
        Intent intent = EditActivity.getProjectIntent(getContext());
        startActivityForResult(intent, REQUEST_ADD);
    }

    @Override
    protected ResumeEventAdapter<Project> getAdapter(View emptyView) {
        return new ProjectsAdapter(getResume().projects, this)
                .setEmptyView(emptyView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_ADD && resultCode == Activity.RESULT_OK) {
            getResume().projects.add(new Project(EditActivity.getEvent(data)));
            notifyDataChanged();
        }
        if (requestCode == REQUEST_EDIT && resultCode == Activity.RESULT_OK) {
            int id = data.getIntExtra(EditActivity.FIELD_ID, -1);
            getResume().projects.get(id).cloneThis(EditActivity.getEvent(data));
            notifyDataChanged();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
