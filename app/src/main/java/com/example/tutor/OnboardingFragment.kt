package com.example.tutor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.tutor.adapters.OnboardingAdapter
import com.example.tutor.databinding.FragmentOnboardingBinding
import com.google.android.material.tabs.TabLayoutMediator

class OnboardingFragment : Fragment(R.layout.fragment_onboarding) {

    private var _binding: FragmentOnboardingBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = view.findViewById<com.google.android.material.tabs.TabLayout>(R.id.pageIndicator)
        val btnNext = view.findViewById<com.google.android.material.button.MaterialButton>(R.id.btnNext)
        val tvSkip = view.findViewById<android.widget.TextView>(R.id.tvSkip)

        val items = listOf(
            OnboardingItem(
                R.drawable.img_onboarding_1,
                "Подбор за минуты, а не за месяцы",
                "ИИ анализирует вашу анкету и подбирает идеального наставника под ваши цели и график."
            ),
            OnboardingItem(
                R.drawable.img_onboarding_2,
                "Человек проверяет пару",
                "Наш куратор вручную проверяет совместимость, чтобы гарантировать качество и комфорт в общении."
            ),
            OnboardingItem(
                R.drawable.img_onboarding_3,
                "Расти и получать награды",
                "Следите за прогрессом, ставьте цели и получайте бейджи и игровую валюту за свои успехи."
            )
        )

        val adapter = OnboardingAdapter(items)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { _, _ -> }.attach()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == items.size - 1) {
                    btnNext.text = "НАЧАТЬ РАБОТУ"
                } else {
                    btnNext.text = "ДАЛЕЕ"
                }
            }
        })

        btnNext.setOnClickListener {
            if (viewPager.currentItem < items.size - 1) {
                viewPager.currentItem += 1
            } else {
                findNavController().navigate(R.id.action_onboardingFragment_to_roleSelectFragment)
            }
        }

        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_roleSelectFragment)
        }
    }
}