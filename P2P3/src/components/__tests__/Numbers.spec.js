import { describe, it, expect, beforeEach, fn } from 'vitest'
import { mount } from '@vue/test-utils'
import { createTestingPinia } from '@pinia/testing'
import { setActivePinia, createPinia } from 'pinia'
import {useDisplayContentStore} from "@/stores/displayContent";
import Numbers from "../Numbers.vue"

describe("Numbers", () => {
    beforeEach(() => {
        setActivePinia(createPinia())
    })
    it ("renders properly", () => {
        
        const numbers = mount(Numbers, {
            global: {
                plugins: [createTestingPinia({
                    createSpy: fn
                })]
            }
        })
        console.log("hei")
        expect(numbers.text()).toContain("2")
    })
})