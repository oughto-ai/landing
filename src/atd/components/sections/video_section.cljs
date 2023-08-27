(ns atd.components.sections.video-section
  (:require [atd.components.elements.video-background :refer [video-background]]
            [atd.components.players.video-player :refer [video-player]]
            [atd.hooks.use-scroll-trigger :refer [use-scroll-trigger]]
            [atd.lib.defnc :refer [defnc]]
            [atd.providers.main-provider :refer [use-main-state]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc video-section
  [{:keys [playback-id]}]
  (let [[state dispatch!] (use-main-state)
        outer-ctx (hooks/use-ref "outer-ctx")
        [visited? is-active?] (use-scroll-trigger outer-ctx {:end "bottom"})]

    (d/div {:id "video"
            :ref outer-ctx
            :class "flex absolute h-full w-full overflow-hidden items-center justify-center"}

           (d/div {:class "w-10/12 lg:w-1/2 relative flex items-center justify-center"}

                  ($ video-player {:playback-id playback-id

                                   :should-play? is-active?})))))