(ns atd.views.landing-view
  (:require [atd.components.section :refer [section]]
            [atd.components.sections.quote-section :refer [quote-section]]
            [atd.components.sections.video-section :refer [video-section]]
            [atd.components.sections.what-section :refer [what-section]]
            [atd.components.sections.contact-section :refer [contact-section]]
            [atd.lib.defnc :refer [defnc]]
            [atd.reducers.requires]
            [atd.components.hero-header :refer [hero-header]]
            [atd.components.navs.progress-menu :refer [progress-menu]]
            [atd.components.sections.mobile-hero-section :refer [mobile-hero-section]]
            [atd.hooks.use-media-query :refer [use-media-query]]
            [atd.components.playful-titles :refer [playful-titles]]

            [helix.core :refer [$]]
            [helix.dom :as d]
            [helix.hooks :as hooks]))

(defnc landing-view []
  (let [container-ref (hooks/use-ref "container-ref")
        #_#_current-index (use-scroll-progress 6 container-ref {:throttle-interval 200})
        is-desktop? (use-media-query :md)]

    ($ :div {:ref container-ref
             :class "swirl"}

       (d/div {:class "fixed z-20 justify-center items-center top-1/2 -translate-y-1/2 left-2"}
              ($ progress-menu {:total-sections 6}))

       (if is-desktop?

         ($ section
            {:key "video"
             :section-id "video"}
            (d/div {:class "w-screen h-screen relative"}
                   (d/div {:class "absolute w-full h-full flex justify-center"}
                          (d/div {:class "flex flex-col items-center"}
                                 (d/div {:class "w-1/4 md:w-32 my-8 "}
                                        (d/img {:src "https://oughto-marketing.imgix.net/wordmark_transparent.png"}))

                                 (d/div {:class "hero-text max-w-1/8"}
                                        (d/span "Welcome to the future of production planning.")))


                          ($ video-section {:playback-id "AmazMM8GMRlb01TYMOpNS01zBC3UGgr89w5BuUr7TzQJ8"}))))
         ($ section
            {:key "mobile-hero"
             :section-id "mobile-hero"}
            (d/div {:class "flex flex-col justify-center items-center justify-items-center "}
                   (d/div {:class "w-1/4 md:w-32 my-8"}
                          (d/img {:src "https://oughto-marketing.imgix.net/wordmark_transparent.png"}))

                   (d/div {:class "hero-text p-8 my-8"}
                          (d/span "Welcome to the future of production planning.")))
            ($ mobile-hero-section)))

       (when is-desktop?
         ($ section
            {:key "hero"
             :section-id "hero"}
            ($ hero-header)))

       ($ section
          {:key "about-tech"
           :section-id "about-tech"}
          ($ quote-section {:section-id "tech-quote"
                            :gradient-class "grey-grad"
                            :from {:opacity 0
                                   :duration 0.5
                                   :ease "expo.inOut",
                                   :stagger 0.01}
                            :to {:opacity 1
                                 :duration 0.1
                                 :ease "expo.inOut",
                                 :stagger 0.1}}
             (d/div {:class "text-slate-300 font-light flex justify-center h-full flex-col md:w-3/4 w-3/4 text-lg md:text-2xl"}
                    (d/p {:class "mb-8 italic"} "We've worked in the food industry for years.")

                    (d/p {:class "mb-8"} (d/span {:class "font-medium text-pink-600"} ":tech ") "is what the large companies use to compete. In the game of operations, efficiency is key. Parallel lines slightly skewed over time can lead to massive inefficiencies.")

                    (d/p {:class " mb-8"}
                         "What are good" (d/span {:class "font-medium text-pink-600"} " :systems ") "and why does it matter?")

                    (d/p {:class " mb-8"}
                         (d/span {:class "font-medium text-pink-600"} ":production ") "is the cornerstone to the juicing operation, but it's people that are at the heart of it, and without right tools, they struggle.")

                    (d/p {:class " mb-8"}
                         "Through disciplined daily action, we build a culture that endures and thrives."))))

       ($ section
          {:key "video-section"
           :section-id "video-section"}
          (d/div {:class "w-screen h-screen relative"}
                 (d/div {:class "absolute w-full h-full"}
                        ($ video-section {:playback-id "pkcols1Hwwi5wExjMwAEe01nf1k2LUo00Ahp44sNQqaok"}))))

       ($ section
          {:key "main-quote"
           :section-id "main-quote"}
          ($ quote-section {:section-id "main-quote"
                            :gradient-class "orange-grad"
                            :quote ["Get ready for the future of juice production planning"
                                    "Signup to our waitlist and get notified when your invite is ready."]}))

       #_($ section
            {:key "doing"
             :section-id "doing"}
            ($ quote-section {:class ""
                              :gradient-class "blue-grad"
                              :section-id "doing"
                              :header "What I Love"
                              :quote ["Making immutable data move."
                                      "Making moving images that make people stop."]}))

       #_($ section
            {:key "what"
             :section-id "what"}
            ($ what-section {:class ""
                             :gradient-class "purple-grad"
                             :section-id "what"}))

       #_($ section
            {:key "contact"
             :section-id "contact"}
            ($ contact-section {:force-on? false
                                :section-id "contact"})))))