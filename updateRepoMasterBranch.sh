#!/bin/bash
git add . && git commit -m '$(echo $(.randStringGenerator/randStringGenerator 10))' && git push origin master
