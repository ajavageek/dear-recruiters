package ch.frankel.blog.recruiting;

/*
 * #%L
 * Dear Recruiters
 * %%
 * Copyright (C) 2014 Nicolas Frankel
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import static ch.frankel.blog.recruiting.Company.CompanyType.SOFTWARE_PRODUCT;
import static ch.frankel.blog.recruiting.CompensationPolicy.NOT_ADEQUATE;
import static ch.frankel.blog.recruiting.ConferencePolicy.WHAT_IS_CONFERENCE;
import static ch.frankel.blog.recruiting.TimePolicy.POSSIBLY_PART_TIME;
import static ch.frankel.blog.recruiting.TimePolicy.TWENTY_PERCENT_PET_PROJECT;
import static ch.frankel.blog.recruiting.TrainingPolicy.NOT_ONLY_SOFTWARE;
import static ch.frankel.blog.recruiting.TrainingPolicy.PROACTIVE;

public class Company {

    private final CompanyType type;
    private final TrainingPolicy training;
    private final ConferencePolicy conference;
    private final TimePolicy time;
    private final CompensationPolicy compensation;

    public Company(CompanyType type, TrainingPolicy training, ConferencePolicy conference, TimePolicy time,
            CompensationPolicy compensation) {
        this.type = type;
        this.training = training;
        this.conference = conference;
        this.time = time;
        this.compensation = compensation;
    }

    public boolean allowsAnotherLife() {
        return time == POSSIBLY_PART_TIME || time == TWENTY_PERCENT_PET_PROJECT;
    }

    public boolean focusOnSoftware() {
        return type == SOFTWARE_PRODUCT;
    }

    public boolean investInPeople() {
        return training == PROACTIVE || training == NOT_ONLY_SOFTWARE;
    }

    public boolean staysUpToDate() {
        return conference != WHAT_IS_CONFERENCE;
    }

    public boolean respectCandidates() {
        return compensation != NOT_ADEQUATE;
    }

    public TrainingPolicy getTraining() {
        return training;
    }

    public ConferencePolicy getConference() {
        return conference;
    }

    public TimePolicy getTime() {
        return time;
    }

    public enum CompanyType {
        UNRELATED_TO_SOFTWARE, CONSULTING, SOFTWARE_PRODUCT
    }
}
