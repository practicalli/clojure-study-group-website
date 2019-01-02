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
    (:require [reagent.core :as reagent :refer [atom]]))


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
(defonce
  app-state
  (atom
   {:website
    {:title       "Clojure Virtual Study Group"
     :description "Learn to think Functionally with Clojure in a series of YouTube broadcasts"
     :copyright   "2019 Practicalli"}
    :broadcasts
    {:CSG-001 {:url "https://www.youtube.com/watch?v=MZcuL4lRw5E"
         :title "Overview of Clojure"
         :description "Discussing the uses of Clojure and a tour of its syntax"}}}))



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



(defn broadcast-card []
  [:div {:class "card"
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



(defn website-title []
  [:div {:class "jumbotron practicalli-jumbotron"}
   [:h1 (get-in @app-state [:website :title])]
   [:h4 (get-in @app-state [:website :description])]])

(defn study-group-website []
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
