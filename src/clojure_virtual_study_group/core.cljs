;; Clojure Virtual Study Group website
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;
;; A website to guide developers into Clojure via video broadcasting
;; Videos are published on YouTube in the jr0cket channel and as a playlist
;; The study group website will allow people to search through the content
;; of each video and find the parts they want to learn next.
;; This website will contain full details to help people follow them study group,
;; including code examples, descriptions, transcripts, etc.


(ns clojure-virtual-study-group.core
  (:require [reagent.core :as reagent]
            [clojure-virtual-study-group.data-model :as data-model :refer [app-state]]))


;; Debugging in the Browser / JavaScript console
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(enable-console-print!)

(println "This text is printed from src/clojure-virtual-study-group/core.cljs. Go ahead and edit it and see reloading in action.")


;; Application State
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; State changes will come from API calls to YouTube (assuming that is possible)
;; Otherwise state will be updated from content files (describing content and providing links)
;; State will be used to control what data should be show, and presentation managed by CSS

;; define your app data so that it doesn't get over-written on reload
#_(defonce
  app-state
  (atom
   {:website
    {:title       "Clojure Virtual Study Group"
     :description "Learn to think Functionally with Clojure in a series of YouTube broadcasts"
     :copyright   "2019 Practicalli"}
    :broadcasts
    {:CSG-001
     {:url "https://www.youtube.com/watch?v=MZcuL4lRw5E"
      :title "Overview of Clojure"
      :description "Discussing the uses of Clojure and a tour of its syntax"
      :thumbnail ""}
     :CSG-002
     {:url "https://www.youtube.com/watch?v=y5TAHwZc1JE"
      :title "REPL Driven Development - ClojureBridge Exercises"
      :description "Fast feedback with the REPL and working through ClojureBridge London exercises."
      :thumbnail ""}
     :CSG-003
     {:url "https://www.youtube.com/watch?v=PmSPKvlJk74"
      :title "Structural editing"
      :description "Editing Clojure without breaking the structure of the code"
      :thumbnail ""}
     :CSG-004
     {:url "https://www.youtube.com/watch?v=ikW6Qk73K1s"
      :title "Working with Data"
      :description "Using hash-map to model and work with data"
      :thumbnail ""}
     :CSG-005
     {:url "https://www.youtube.com/watch?v=LvissLmUNho"
      :title "clojure.test"
      :description "Writing unit tests in Clojure"
      :thumbnail ""}
     :CSG-006
     {:url "https://www.youtube.com/watch?v=opM7fU7IAV8"
      :title "Advent of Clojure"
      :description "Various solutions to day 1 challenge"
      :thumbnail ""}
     :CSG-007
     {:url "https://www.youtube.com/watch?v=WYaIy3E6nLk"
      :title "Reagent - a simple website"
      :description "Intro to Clojurescript and reagent"
      :thumbnail ""}
     :CSG-008
     {:url "https://www.youtube.com/watch?v=8u8y73zh0w0"
      :title "4Clojure continued"
      :description "Working through exercises 16 to 22"
      :thumbnail ""}
     :CSG-009
     {:url "https://www.youtube.com/watch?v=_eO7EsXO2XE"
      :title "Functional TicTacToe"
      :description "Functional approach to building the TicTacToe game"
      :thumbnail ""}
     :CSG-010
     {:url ""
      :title ""
      :description ""
      :thumbnail ""}}}))


;; Reagent components
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Ensure all components and sub-components are treated as reagent components,
;; by placing them in [] rather than as function calls (e.g. in the reagent/render-component)
;; and any component that render-component manages.

;; Components could include:
;; * study-group-website - the main component
;; * broadcast-recording
;; * scheduled-broadcast
;; * broadcast-description
;; * thumbnail of study session
;; * an ordered list of study sessions
;; * full display of a study session


(defn broadcast-next-card []
  [:div {:class "card"
         :width "18rem"}
   [:h5 {:class "card-title"}
    (get-in @app-state [:broadcasts :CSG-001 :title])]
   [:div {:class "card-body"}
    [:h5 {:class "card-title"}
     (get-in @app-state [:broadcasts :CSG-001 :title])]
    [:p {:class "card-text"}
     (get-in @app-state [:broadcasts :CSG-001 :description])]
    [:a {:href "https://www.youtube.com/watch?v=MZcuL4lRw5E"
         :class "btn btn-primary"}
     "Play Broadcast"]]])

#_(defn broadcast-card []
  [:div {:class "card mb-4 shadow-sm"
         :width "18rem"}
   [:img {:src "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5d/Clojure_logo.svg/200px-Clojure_logo.svg.png"}]
   [:div {:class "card-body"}
    [:h5 {:class "card-title"}
     (get-in @app-state [:broadcasts :CSG-001 :title])]
    [:p {:class "card-text"}
     (get-in @app-state [:broadcasts :CSG-001 :description])]
    [:a {:href "https://www.youtube.com/watch?v=MZcuL4lRw5E"
         :class "btn btn-primary"}
     "Play Broadcast"]]])

;; Refactor broadcast-card to take a specific map of details for a broadcast.
;; This makes the broadcast-card less coupled to the application state
;;

(defn broadcast-card [broadcast-details]
  [:div {:class "card mb-4 shadow-sm"
         :width "36rem"}
   [:img {:src (get broadcast-card :thumbnail)}]
   [:div {:class "card-body"}
    [:h5 {:class "card-title"}
     (get broadcast-details :title)]
    [:p {:class "card-text"}
     (get broadcast-details  :description)]
    [:a {:href (get broadcast-details :url)
         :class "btn btn-primary"}
     "Play Broadcast"]]])



(defn website-title []
  [:div {:class "jumbotron practicalli-jumbotron"}
   [:h1 (get-in @app-state [:website :title])]
   [:h4 (get-in @app-state [:website :description])]])

#_(defn study-group-website []
  [:div {:class "container"}
   [website-title]

   ;; Broadcasts
   [:div {:class "row"}

    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    [:div {:class "col-md-3"}
     [broadcast-card]]
    ]
   ])


(defn broadcast-carousel
  "Displays the broadcasts as a carousel using Bootstrap"
  [broadcasts]
  [:div {:class "row"}
   (for [broadcast broadcasts]
     [:div {:class "col-md-3"}
      [broadcast-card broadcast]])])


(defn study-group-website []
  [:div {:class "container"}
   [website-title]

   ;; Broadcasts
   [broadcast-carousel (@app-state :broadcasts)]
   ])



;; Reagent specific code
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(reagent/render-component [study-group-website]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

;; REPL design journal
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; Testing update of app-state
#_(swap! app-state assoc-in [:website :title] "Test Title Update")

;; Reset app-state to known start state
#_(reset!
 app-state
 {:website
  {:title       "Clojure Virtual Study Group"
   :description "Learn to think Functionally with Clojure in a series of YouTube broadcasts"
   :copyright   "2019 Practicalli"}
  :broadcasts
  {:1 {:url "https://www.youtube.com/watch?v=MZcuL4lRw5E"
       :title "Overview of Clojure"
       :description "Discussing the uses of Clojure and a tour of its syntax"}}})

#_@app-state


#_(get-in @app-state [:broadcasts :CSG-001 :description])

#_(reset!
 app-state
 {:website
  {:title       "Clojure Virtual Study Group"
   :description "Learn to think Functionally with Clojure in a series of YouTube broadcasts"
   :copyright   "2019 Practicalli"}
  :broadcasts
  {:CSG-001 {:url "https://www.youtube.com/watch?v=MZcuL4lRw5E"
             :title "Overview of Clojure"
             :description "Discussing the uses of Clojure and a tour of its syntax"}}})



(@app-state :broadcasts)
