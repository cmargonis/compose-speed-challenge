/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.home

import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R

data class SootheItem(@DrawableRes val image: Int, val title: String)

val favoritesFirst = listOf(
    SootheItem(R.drawable.short_mantras, "Short mantras"),
    SootheItem(R.drawable.stress_and_anxiety, "Stress and anxiety"),
    SootheItem(R.drawable.nature_meditations, "Nature meditations")
)

val favoritesSecond = listOf(
    SootheItem(R.drawable.self_massage, "Self-massage"),
    SootheItem(R.drawable.pre_natal_yoga, "Pre natal yoga"),
    SootheItem(R.drawable.high_stress, "High stress")
)

val bodyItems = listOf(
    SootheItem(R.drawable.inversions, "Inversions"),
    SootheItem(R.drawable.quick_yoga, "Quick yoga"),
    SootheItem(R.drawable.stretching, "Stretching"),
    SootheItem(R.drawable.tabata, "Tabata"),
    SootheItem(R.drawable.nightly_wind_down, "Wind down"),
    SootheItem(R.drawable.hiit, "Hiit")
)

val mindItems = listOf(
    SootheItem(R.drawable.medidate, "Meditate"),
    SootheItem(R.drawable.with_kids, "With kids"),
    SootheItem(R.drawable.aromatherapy, "Aromatherapy"),
    SootheItem(R.drawable.with_pets, "With pets"),
    SootheItem(R.drawable.on_the_go, "On the go"),
    SootheItem(R.drawable.overwhelmed, "Overwhelmed")
)
