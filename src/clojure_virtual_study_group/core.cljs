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
(defonce app-state (atom {:text "Hello world!"}))



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



(defn hello-world []
  [:div
   [:h1 (:text @app-state)]
   [:h3 "Edit this and watch it change!"]])



;; Reagent specific code
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
