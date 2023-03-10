import { describe, it, expect, vitest, vi } from 'vitest'
import { createTestingPinia } from '@pinia/testing'
import { mount } from '@vue/test-utils'
import Log from "../Log.vue"

describe("Log", () => {
    it ("renders empty", () => {
        const log = mount(Log, {
            global: {
                plugins: [createTestingPinia({
                    stubActions: false,
                    createSpy: vitest.fn
                })],
            },
        })
        
        expect(log.text()).toContain("")
    })
})
