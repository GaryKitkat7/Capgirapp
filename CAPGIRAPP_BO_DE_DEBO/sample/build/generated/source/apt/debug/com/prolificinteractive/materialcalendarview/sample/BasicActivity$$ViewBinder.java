// Generated code from Butter Knife. Do not modify!
package com.prolificinteractive.materialcalendarview.sample;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class BasicActivity$$ViewBinder<T extends com.prolificinteractive.materialcalendarview.sample.BasicActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131492968, "field 'widget'");
    target.widget = finder.castView(view, 2131492968, "field 'widget'");
    view = finder.findRequiredView(source, 2131492970, "field 'textView'");
    target.textView = finder.castView(view, 2131492970, "field 'textView'");
  }

  @Override public void unbind(T target) {
    target.widget = null;
    target.textView = null;
  }
}
