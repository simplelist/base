package com.jack.gecco.controller;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;

/**
 * Created by jackshi on 16/4/7.
 */
@PipelineName("consolePipeline")
public class ConsolePipeline implements Pipeline<GeccoTest> {
    @Override
    public void process(GeccoTest geccoTest) {
        System.out.println(geccoTest.getContent());
    }
}
