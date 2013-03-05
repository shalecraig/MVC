package com.sakcraig.mvc;

import com.sakcraig.mvc.Observable.ChangeType;

public interface Observer {
	public void changed(long changeTime, ChangeType r);
}
