# clojure-virtual-study-group

A website langing pages for the Practicalli Clojure virtual Study Group.

The website is created in ClojureScript with Bootstrap CSS library for styles.

## Overview

FIXME: Write a paragraph about the library/project and highlight its goals.

## Setup

Start an interactive development environment (REPL driven by Figwheel), either use your favourite editor or on the command line, run:

    lein figwheel

and open your browser at [localhost:3449](http://localhost:3449/) (this should open automatically though).

Each time you save changes or evaluate code it is auto compiled and all changes are sent to the browser without the need to reload. After the compilation process is complete, you will get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

## Production build

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## Deployment

Current deployment is manually copying the following files to the `clojure-study-group` project:

* `resources/public/index.html`
* `resources/public/css/`
* `resources/public/js`


## License

Copyright © 2019 Practicalli

Distributed under the Creative Commons Attribution Share-Alike 4.0 International.
