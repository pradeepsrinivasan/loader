package com.flipkart.perf.controller;

import com.flipkart.perf.core.LoadController;
import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;

public class JobController {

    private final LoadController loadController;

    public JobController(LoadController loadController) {
        this.loadController = loadController;
    }

    /**
     * Kill the job abruptly
     * @param request
     * @param response
     */
    public void kill(Request request, Response response) {
        loadController.stop();
    }
}
