(ns atd.components.navs.logo-nav
  (:require ["@heroicons/react/24/outline" :as icons]
            [atd.hooks.use-hover-animations :refer [use-hover-animations]]
            [atd.hooks.use-scroll-trigger :refer [use-scroll-trigger]]
            [atd.hooks.use-toggle-animations :refer [use-toggle-animations]]
            [atd.utils.window :as win-utils]
            [atd.lib.defnc :refer [defnc]]
            [helix.core :refer [$]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))



(defnc logo-nav
  []
  (let [comp-ref (hooks/use-ref "comp-ref")
        [visited? is-active?] (use-scroll-trigger comp-ref :start (fn [] (- (win-utils/height) (/ (win-utils/height) 8)))
                                                  :end "1000000px"
                                                  :markers? false
                                                  :debug? false)]
    (use-hover-animations comp-ref
                          :over {:opacity 1}
                          :out {:opacity 0.7})

    (use-toggle-animations
     comp-ref
     :on {:y 0}
     :off {:y -150}
     :is-on? is-active?
     :initial false)

    (d/div {:ref comp-ref
            :class "fixed opacity-90 z-30 text-xl ml-4 mt-4 w-1/5 md:w-32 p-2 bg-white"}
           (d/img {:src "https://oughto-marketing.imgix.net/wordmark.png"}))))



