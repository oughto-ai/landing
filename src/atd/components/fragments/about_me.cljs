(ns atd.components.fragments.about-me
  (:require
   [atd.lib.defnc :refer [defnc]]
   [helix.dom :as d]))

(defnc about-me
  []
  (d/div {:class "text-slate-800 flex justify-center flex-col w-4/5 md:w-1/2 bg-white/50 backdrop-blur-md p-8"}
         (d/p {:class "text-2xl md:text-4xl mb-4 "} "Hello. We're Oughto")
         (d/p {:class "text-md md:text-xl mb-4"} "A modern way to run production planning for your juice bar.")
         (d/p {:class "text-md md:text-xl mb-4"} "We come from the industry and understand the struggles.")
         (d/p {:class "text-md md:text-xl"} "Things are moving fast.")
         (d/p {:class "text-md md:text-xl"} "It's time to play.")))