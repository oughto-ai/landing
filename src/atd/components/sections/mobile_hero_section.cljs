(ns atd.components.sections.mobile-hero-section
  (:require [atd.components.elements.video-background :refer [video-background]]
            [atd.components.players.video-player :refer [video-player]]
            [atd.hooks.use-scroll-trigger :refer [use-scroll-trigger]]
            [atd.lib.defnc :refer [defnc]]
            [atd.components.fragments.about-me :refer [about-me]]
            [atd.providers.main-provider :refer [use-main-state]]
            [atd.components.writing-card :refer [writing-card]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc mobile-hero-section
  []
  (let [[state dispatch!] (use-main-state)
        outer-ctx (hooks/use-ref "outer-ctx")
        [visited? is-active?] (use-scroll-trigger outer-ctx {:end "bottom"})]

    (d/div {:id "video"
            :ref outer-ctx
            :class "relative flex items-center justify-items-center justify-center overflow-hidden"}


           (d/div {:class "w-full md:w-10/12 lg:w-12 flex relative  flex items-center justify-items-center justify-center"}

                  ($ video-player {:playback-id "AmazMM8GMRlb01TYMOpNS01zBC3UGgr89w5BuUr7TzQJ8"
                                   :should-play? is-active?})

                  #_($ writing-card
                       ($ about-me))))))