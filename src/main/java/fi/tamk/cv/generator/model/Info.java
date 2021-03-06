/*
Copyright 2019 Hanna Haataja <hanna.haataja@tuni.fi>. All rights reserved.

Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
following conditions are met:

1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following
disclaimer.

2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
disclaimer in the documentation and/or other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package fi.tamk.cv.generator.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import fi.tamk.cv.generator.model.datatypes.DataType;
import fi.tamk.cv.generator.rest.InfoDeserializer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonDeserialize(using = InfoDeserializer.class)
public class Info {
    private int order;
    private boolean visible;
    private ArrayList<DataType> data;

    public Info(int order, boolean visible, ArrayList<DataType> data) {
        this.order = order;
        this.visible = visible;
        this.data = data;
    }

    public Info(int order, boolean visible) {
        this.order = order;
        this.visible = visible;
        this.data = new ArrayList<>();
    }

    public List<List<Object>> toListOfLists() {
        List<Object> list = Arrays.asList(order, visible);
        List<List<Object>> listOfLists = new ArrayList<>();
        listOfLists.add(list);
        if (data.size() > 0) {
            for (DataType dataSample : data) {
                listOfLists.add(dataSample.toList());
            }
        }
        return listOfLists;
    }

    public Info() {
        this.data = new ArrayList<>();
    }

    public ArrayList<DataType> getData() {
        return data;
    }

    public void setData(ArrayList<DataType> data) {
        this.data = data;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
