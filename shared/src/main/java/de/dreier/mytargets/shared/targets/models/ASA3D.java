/*
 * Copyright (C) 2016 Florian Dreier
 *
 * This file is part of MyTargets.
 *
 * MyTargets is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2
 * as published by the Free Software Foundation.
 *
 * MyTargets is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */
package de.dreier.mytargets.shared.targets.models;

import de.dreier.mytargets.shared.R;
import de.dreier.mytargets.shared.targets.Target3DBase;
import de.dreier.mytargets.shared.targets.scoringstyle.ScoringStyle;
import de.dreier.mytargets.shared.targets.zone.CircularZone;
import de.dreier.mytargets.shared.targets.zone.HeartZone;
import de.dreier.mytargets.shared.targets.zone.ZoneBase;

import static de.dreier.mytargets.shared.utils.Color.BLACK;
import static de.dreier.mytargets.shared.utils.Color.BROWN;
import static de.dreier.mytargets.shared.utils.Color.CERULEAN_BLUE;
import static de.dreier.mytargets.shared.utils.Color.GRAY;
import static de.dreier.mytargets.shared.utils.Color.LIGHT_GRAY;
import static de.dreier.mytargets.shared.utils.Color.TURBO_YELLOW;

public class ASA3D extends Target3DBase {

    public ASA3D() {
        super(15, R.string.asa_3d);
        zones = new ZoneBase[]{
                new CircularZone(0.053396f, 0.274396f, -0.089198f, TURBO_YELLOW, BLACK, 3),
                new CircularZone(0.053396f, -0.017104004f, 0.399802f, TURBO_YELLOW, BLACK, 3),
                new CircularZone(0.124f, 0.274396f, -0.089198f, TURBO_YELLOW, BLACK, 3),
                new CircularZone(0.124f, -0.017104004f, 0.399802f, TURBO_YELLOW, BLACK, 3),
                new CircularZone(0.417876f, 0.12875f, 0.15562597f, CERULEAN_BLUE, BLACK, 4),
                new HeartZone(1.0f, 0.0f, 0.0f, LIGHT_GRAY, BLACK, 3),
                new CircularZone(1.0f, 0.0f, 0.0f, BROWN, GRAY, 5)
        };
        scoringStyles = new ScoringStyle[]{new ScoringStyle(false, 12, 12, 12, 12, 10, 8, 5)};
    }
}