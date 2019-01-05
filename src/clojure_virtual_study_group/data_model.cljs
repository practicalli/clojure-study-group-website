(ns clojure-virtual-study-group.data-model
  (:require [reagent.core :as reagent :refer [atom]]))

(defonce
  app-state
  (atom
   {:website
    {:title       "Clojure Virtual Study Group"
     :description "Learn to think Functionally with Clojure in a series of YouTube broadcasts"
     :copyright   "2019 Practicalli"}
    :broadcasts
    [{:id :CSG-001
      :url "https://www.youtube.com/watch?v=MZcuL4lRw5E"
      :title "Overview of Clojure"
      :description "Discussing the uses of Clojure and a tour of its syntax"
      :thumbnail "/images/clojure-logo.png"}

     {:id :CSG-002
      :url "https://www.youtube.com/watch?v=y5TAHwZc1JE"
      :title "REPL Driven Development"
      :description "Working through ClojureBridge exercises."
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-003
      :url "https://www.youtube.com/watch?v=PmSPKvlJk74"
      :title "Structural editing"
      :description "Editing Clojure without breaking the structure of the code"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-004
      :url "https://www.youtube.com/watch?v=ikW6Qk73K1s"
      :title "Working with Data"
      :description "Using hash-map to model and work with data"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-005
      :url "https://www.youtube.com/watch?v=LvissLmUNho"
      :title "clojure.test"
      :description "Writing unit tests in Clojure"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-006
      :url "https://www.youtube.com/watch?v=opM7fU7IAV8"
      :title "Advent of Clojure"
      :description "Various solutions to day 1 challenge"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-007
      :url "https://www.youtube.com/watch?v=WYaIy3E6nLk"
      :title "Reagent - a simple website"
      :description "Intro to Clojurescript and reagent"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-008
      :url "https://www.youtube.com/watch?v=8u8y73zh0w0"
      :title "4Clojure continued"
      :description "Working through exercises 16 to 22"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-009
      :url "https://www.youtube.com/watch?v=_eO7EsXO2XE"
      :title "Functional TicTacToe"
      :description "Functional approach to building the TicTacToe game"
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }

     {:id :CSG-010
      :url ""
      :title ""
      :description ""
      :thumbnail "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png" }]}))
