package com.ibo.compsci.groovy

import geb.Page

class TheBookOfGebPage extends Page {
    static at = { title.startsWith("The Book of Geb") }
}
